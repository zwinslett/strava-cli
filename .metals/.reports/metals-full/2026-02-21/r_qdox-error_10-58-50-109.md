error id: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[24,2]

error in qdox parser
file content:
```java
offset: 947
uri: file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java
text:
```scala
package com.zwinslett.strava;

import java.util.List;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "stats", description = "Display stats about a range of activities")
public class StatsCommand implements Runnable {
    @Parameters(index="0",description ="The time range of activities to calculate stats for (e.g., 'week', 'month', 'year')", arity = "1")
    private String timeRange;

    @Override
    public void run() {
        StravaAPIClient stravaRequest = new StravaAPIClient();
        try {
            String accessToken = stravaRequest.getAccessToken();
            List<Activity> recentActivityData = stravaRequest.getRecentActivities(accessToken, 10); // Fetch up to 100 recent activities
            ActivityStats stats = new ActivityStats();
            double totalMiles = stats.totalMiles(recentActivityData);
        } catch (Exception e) {
            e.printStackTrace();
    }
}@@
```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:936)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1623)
```
#### Short summary: 

QDox parse error in file://<WORKSPACE>/src/main/java/com/zwinslett/strava/StatsCommand.java