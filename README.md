# slf4j-net-commons-logging

Pipe SLF4J logs in an IKVM'd jar through to https://github.com/net-commons/common-logging

Control the Java logging emitted by your
IKVM'd dlls, coercing them into using the logging infrastructure
you have in place on the .NET side.

## Motive

By now, many Java libraries use slf4j for logging, so the user of the
library can use their preferred logging framework to display the logs.
Ideally, system-wide logging can be configured in a single place.

Common.Logging is a similar idea for .NET: http://netcommon.sourceforge.net/

It supports Log4Net, NLog, System.Console, System.Diagnostics.Trace etc

Wouldn't it be nice if your slf4j logs could be routed to the
preferred .NET logging implementation?

I thought so.. and it turns out that binding Common.Logging to slf4j
is pretty straightforward; see 
https://github.com/plutext/slf4j-net-commons-logging/tree/master/src/main/java

## Users

Note: this project will only help if the IKVM'd jars use slf4j, as opposed to
a hard coded dependency on log4j, JUL, Commons-Logging etc.

To try it out, you need 3 DLLs:

- IKVM'd slf4j-api
- IKVM'd version of the above source
- Common.Logging

Then just follow the Common.Logging doco to configure:
http://netcommon.sourceforge.net/documentation.html

You can get the 3 DLLs from NuGet:
- https://www.nuget.org/packages/slf4j-api/1.7.5
- https://www.nuget.org/packages/slf4j-NetCommonLogging/1.0.0
- https://www.nuget.org/packages/Common.Logging/

or if you aren't using NuGet:
https://github.com/plutext/slf4j-net-commons-logging/tree/master/dotNET/lib/net20
and https://github.com/net-commons/common-logging/downloads

If you get a ClassNotFoundException, one way around that may be to add:

```java
            ikvm.runtime.Startup.addBootClassPathAssembly(
                System.Reflection.Assembly.GetAssembly(
                    typeof(org.slf4j.impl.StaticLoggerBinder)));
```         

## Developers

The source code here is Java, not C#/.NET. So you'll need a Java dev env.

Compile using ant, target 'dist.NET'.

That'll write dlls to dotNET/lib/net20    


                    