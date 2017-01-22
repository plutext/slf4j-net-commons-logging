/**
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

import java.io.Serializable;

import org.slf4j.Marker;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.spi.LocationAwareLogger;

public class NetCommonsLoggerAdapter extends MarkerIgnoringBase implements
		LocationAwareLogger, Serializable {

	private static final long serialVersionUID = 6182834493563598289L;

	final transient cli.Common.Logging.ILog logger;

	final static String FQCN = NetCommonsLoggerAdapter.class.getName();

	// WARN: Log4jLoggerAdapter constructor should have only package access so
	// that
	// only NetCommonsLoggerFactory be able to create one.
	NetCommonsLoggerAdapter(cli.Common.Logging.ILog logger) {
		this.logger = logger;
		// this.name = logger.getName();
	}

	/**
	 * Is this logger instance enabled for the TRACE level?
	 * 
	 * @return True if this Logger is enabled for level TRACE, false otherwise.
	 */
	public boolean isTraceEnabled() {

		return logger.get_IsTraceEnabled();

	}

	/**
	 * Log a message object at level TRACE.
	 * 
	 * @param msg
	 *            - the message object to be logged
	 */
	public void trace(String msg) {
		logger.Trace(msg);
	}

	/**
	 * Log a message at level TRACE according to the specified format and
	 * argument.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for level TRACE.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arg
	 *            the argument
	 */
	public void trace(String format, Object arg) {
		logger.TraceFormat(format, arg);
	}

	/**
	 * Log a message at level TRACE according to the specified format and
	 * arguments.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the TRACE level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arg1
	 *            the first argument
	 * @param arg2
	 *            the second argument
	 */
	public void trace(String format, Object arg1, Object arg2) {
		logger.TraceFormat(format, arg1, arg2);
	}

	/**
	 * Log a message at level TRACE according to the specified format and
	 * arguments.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the TRACE level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arguments
	 *            an array of arguments
	 */
	public void trace(String format, Object... arguments) {
		logger.TraceFormat(format, arguments);
	}

	/**
	 * Log an exception (throwable) at level TRACE with an accompanying message.
	 * 
	 * @param msg
	 *            the message accompanying the exception
	 * @param t
	 *            the exception (throwable) to log
	 */
	public void trace(String msg, Throwable t) {
		logger.Trace(msg, t);
	}

	/**
	 * Is this logger instance enabled for the DEBUG level?
	 * 
	 * @return True if this Logger is enabled for level DEBUG, false otherwise.
	 */
	public boolean isDebugEnabled() {
		return logger.get_IsDebugEnabled();
	}

	/**
	 * Log a message object at level DEBUG.
	 * 
	 * @param msg
	 *            - the message object to be logged
	 */
	public void debug(String msg) {
		logger.Debug(msg);
	}

	/**
	 * Log a message at level DEBUG according to the specified format and
	 * argument.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for level DEBUG.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arg
	 *            the argument
	 */
	public void debug(String format, Object arg) {
		logger.DebugFormat(format, arg);
	}

	/**
	 * Log a message at level DEBUG according to the specified format and
	 * arguments.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the DEBUG level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arg1
	 *            the first argument
	 * @param arg2
	 *            the second argument
	 */
	public void debug(String format, Object arg1, Object arg2) {
		logger.DebugFormat(format, arg1, arg2);
	}

	/**
	 * Log a message at level DEBUG according to the specified format and
	 * arguments.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the DEBUG level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arguments
	 *            an array of arguments
	 */
	public void debug(String format, Object... arguments) {
		logger.DebugFormat(format, arguments);
	}

	/**
	 * Log an exception (throwable) at level DEBUG with an accompanying message.
	 * 
	 * @param msg
	 *            the message accompanying the exception
	 * @param t
	 *            the exception (throwable) to log
	 */
	public void debug(String msg, Throwable t) {
		logger.Debug(msg, t);
	}

	/**
	 * Is this logger instance enabled for the INFO level?
	 * 
	 * @return True if this Logger is enabled for the INFO level, false
	 *         otherwise.
	 */
	public boolean isInfoEnabled() {
		return logger.get_IsInfoEnabled();
	}

	/**
	 * Log a message object at the INFO level.
	 * 
	 * @param msg
	 *            - the message object to be logged
	 */
	public void info(String msg) {
		logger.Info(msg);
	}

	/**
	 * Log a message at level INFO according to the specified format and
	 * argument.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the INFO level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arg
	 *            the argument
	 */
	public void info(String format, Object arg) {
		logger.InfoFormat(format, arg);
	}

	/**
	 * Log a message at the INFO level according to the specified format and
	 * arguments.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the INFO level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arg1
	 *            the first argument
	 * @param arg2
	 *            the second argument
	 */
	public void info(String format, Object arg1, Object arg2) {
		logger.InfoFormat(format, arg1, arg2);
	}

	/**
	 * Log a message at level INFO according to the specified format and
	 * arguments.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the INFO level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param argArray
	 *            an array of arguments
	 */
	public void info(String format, Object... argArray) {
		logger.InfoFormat(format, argArray);
	}

	/**
	 * Log an exception (throwable) at the INFO level with an accompanying
	 * message.
	 * 
	 * @param msg
	 *            the message accompanying the exception
	 * @param t
	 *            the exception (throwable) to log
	 */
	public void info(String msg, Throwable t) {
		logger.Info(msg, t);
	}

	/**
	 * Is this logger instance enabled for the WARN level?
	 * 
	 * @return True if this Logger is enabled for the WARN level, false
	 *         otherwise.
	 */
	public boolean isWarnEnabled() {
		return logger.get_IsWarnEnabled();
	}

	/**
	 * Log a message object at the WARN level.
	 * 
	 * @param msg
	 *            - the message object to be logged
	 */
	public void warn(String msg) {
		logger.Warn(msg);
	}

	/**
	 * Log a message at the WARN level according to the specified format and
	 * argument.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the WARN level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arg
	 *            the argument
	 */
	public void warn(String format, Object arg) {
		logger.WarnFormat(format, arg);
	}

	/**
	 * Log a message at the WARN level according to the specified format and
	 * arguments.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the WARN level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arg1
	 *            the first argument
	 * @param arg2
	 *            the second argument
	 */
	public void warn(String format, Object arg1, Object arg2) {
		logger.WarnFormat(format, arg1, arg2);
	}

	/**
	 * Log a message at level WARN according to the specified format and
	 * arguments.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the WARN level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param argArray
	 *            an array of arguments
	 */
	public void warn(String format, Object... argArray) {
		logger.WarnFormat(format, argArray);
	}

	/**
	 * Log an exception (throwable) at the WARN level with an accompanying
	 * message.
	 * 
	 * @param msg
	 *            the message accompanying the exception
	 * @param t
	 *            the exception (throwable) to log
	 */
	public void warn(String msg, Throwable t) {
		logger.Warn(msg, t);
	}

	/**
	 * Is this logger instance enabled for level ERROR?
	 * 
	 * @return True if this Logger is enabled for level ERROR, false otherwise.
	 */
	public boolean isErrorEnabled() {
		return logger.get_IsErrorEnabled();
	}

	/**
	 * Log a message object at the ERROR level.
	 * 
	 * @param msg
	 *            - the message object to be logged
	 */
	public void error(String msg) {
		logger.Error(msg);
	}

	/**
	 * Log a message at the ERROR level according to the specified format and
	 * argument.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the ERROR level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arg
	 *            the argument
	 */
	public void error(String format, Object arg) {
		logger.ErrorFormat(format, arg);
	}

	/**
	 * Log a message at the ERROR level according to the specified format and
	 * arguments.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the ERROR level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param arg1
	 *            the first argument
	 * @param arg2
	 *            the second argument
	 */
	public void error(String format, Object arg1, Object arg2) {
		logger.ErrorFormat(format, arg1, arg2);
	}

	/**
	 * Log a message at level ERROR according to the specified format and
	 * arguments.
	 * 
	 * <p>
	 * This form avoids superfluous object creation when the logger is disabled
	 * for the ERROR level.
	 * </p>
	 * 
	 * @param format
	 *            the format string
	 * @param argArray
	 *            an array of arguments
	 */
	public void error(String format, Object... argArray) {
		logger.ErrorFormat(format, argArray);
	}

	/**
	 * Log an exception (throwable) at the ERROR level with an accompanying
	 * message.
	 * 
	 * @param msg
	 *            the message accompanying the exception
	 * @param t
	 *            the exception (throwable) to log
	 */
	public void error(String msg, Throwable t) {
		logger.Error(msg, t);
	}

	public void log(Marker marker, String callerFQCN, int level, String msg,
			Object[] argArray, Throwable t) {
		
		if (logger==null) return;
		if (msg==null) return;
		if (argArray==null) return;
		
		switch (level) {
			case LocationAwareLogger.TRACE_INT:
				logger.TraceFormat(msg, t, argArray);
				return;
			case LocationAwareLogger.DEBUG_INT:
				logger.DebugFormat(msg, t, argArray);
				return;
			case LocationAwareLogger.INFO_INT:
				logger.InfoFormat(msg, t, argArray);
				return;
			case LocationAwareLogger.WARN_INT:
				logger.WarnFormat(msg, t, argArray);
				return;
			case LocationAwareLogger.ERROR_INT:
				logger.ErrorFormat(msg, t, argArray);
				return;
			default:
				throw new IllegalStateException("Level number " + level
						+ " is not recognized.");
		}
	}

}
