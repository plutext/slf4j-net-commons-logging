/**
 * 
 * Copyright (c) 2004-2011 QOS.ch and 2014 Plutext Pty Ltd
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package com.plutext.slf4jNetCommonsLogging;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import cli.Common.Logging.LogManager;

public class NetCommonsLoggerFactory implements ILoggerFactory 
{
    // ConcurrentDictionary is only in .NET 4
    // but NuGet package taskparallellibrary has one
    // System.Collections.Concurrent.ConcurrentDictionary<String, org.slf4j.Logger> 
	// but ikvmstub doesn't expose it, so just use the Java one

    // key: name (String), value: a Log4jLoggerAdapter;
    ConcurrentMap<String, Logger> loggerMap;


    public NetCommonsLoggerFactory() {
      loggerMap = new ConcurrentHashMap<String, Logger>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.slf4j.ILoggerFactory#getLogger(java.lang.String)
     */
    public Logger getLogger(String name) {
      Logger slf4jLogger = loggerMap.get(name);
      if (slf4jLogger != null) {
        return slf4jLogger;
      } else {
    	cli.Common.Logging.ILog log4jLogger;
        if(name.equalsIgnoreCase(Logger.ROOT_LOGGER_NAME))
          log4jLogger = LogManager.GetLogger(Logger.ROOT_LOGGER_NAME);
        else
          log4jLogger = LogManager.GetLogger(name);

        Logger newInstance = new NetCommonsLoggerAdapter(log4jLogger);
        Logger oldInstance = loggerMap.putIfAbsent(name, newInstance);
        return oldInstance == null ? newInstance : oldInstance;
      }
    }
  }