# Java Concurrency Recipes

From the book "Java 9 Concurrency Cookbook, Second Edition, by Javier Fernández González"

## Thread Management

* [recipe01](/src/main/java/javathreads/threadmanagement/recipe01/) Starting a thread, name of a thread, status and priority of threads
* [recipe02](/src/main/java/javathreads/threadmanagement/recipe02/) Interrupting a thread
* [recipe03](/src/main/java/javathreads/threadmanagement/recipe03/) Controlling the interruption of a thread
* [recipe04](/src/main/java/javathreads/threadmanagement/recipe04/) Sleeping and resuming a thread
* [recipe05](/src/main/java/javathreads/threadmanagement/recipe05/) Waiting for the finalisation of a thread
* [recipe06](/src/main/java/javathreads/threadmanagement/recipe06/) Creating and running a daemon thread
* [recipe07](/src/main/java/javathreads/threadmanagement/recipe07/) Processing uncontrolled exceptions in a thread
* [recipe08](/src/main/java/javathreads/threadmanagement/recipe08/) Using thread local variables
* [recipe09](/src/main/java/javathreads/threadmanagement/recipe09/) Grouping threads
* [recipe10](/src/main/java/javathreads/threadmanagement/recipe10/) Creating threads through a factory

## Basic thread synchronization

* [recipe01](/src/main/java/javathreads/basicsynchronization/recipe01/) Synchronizing a method
* [recipe02](/src/main/java/javathreads/basicsynchronization/recipe02/) Using conditions in a synchronized code
* [recipe03](/src/main/java/javathreads/basicsynchronization/recipe03/) Synchronizing a block of code with lock
* [recipe04](/src/main/java/javathreads/basicsynchronization/recipe04/) Synchronizing data access with read/write locks
* [recipe05](/src/main/java/javathreads/basicsynchronization/recipe05/) Using multiple conditions in a lock

## Thread Synchronization Utilities

* [recipe01](/src/main/java/javathreads/synchronizationutilities/recipe01/) Semaphores - Controlling concurrent access to one or more copies of a resource
* [recipe02](/src/main/java/javathreads/synchronizationutilities/recipe02/) CountDownLatch - Waiting for multiple concurrent updates
* [recipe03](/src/main/java/javathreads/synchronizationutilities/recipe03/) CyclicBarrier - Synchronizing tasks in a common point
* [recipe04](/src/main/java/javathreads/synchronizationutilities/recipe04/) Phaser - Running concurrent-phased tasks
* [recipe05](/src/main/java/javathreads/synchronizationutilities/recipe05/) Phaser - Controlling phase change in concurrent-phased tasks
* [recipe06](/src/main/java/javathreads/synchronizationutilities/recipe06/) Exchanger - Exchanging data between concurrent tasks
* [recipe07](/src/main/java/javathreads/synchronizationutilities/recipe07/) CompletableFuture - Completing and linking tasks asynchronously

## Executors

* [recipe01](/src/main/java/javathreads/executors/recipe01/)  Creating a thread executor and controlling its rejected tasks
* [recipe02](/src/main/java/javathreads/executors/recipe02/) Execute a task in an executor that returns a result
* [recipe03](/src/main/java/javathreads/executors/recipe03/) Running multiple tasks and processing of the first result (the fastest result)
* [recipe04](/src/main/java/javathreads/executors/recipe04/) Running multiple tasks and processing all the results
* [recipe05](/src/main/java/javathreads/executors/recipe05/) Running a task in an executor after a delay
* [recipe06](/src/main/java/javathreads/executors/recipe06/) Executing a task in an executor periodically
* [recipe07](/src/main/java/javathreads/executors/recipe07/) Cancelling a task in an executor
* [recipe08](/src/main/java/javathreads/executors/recipe08/) Controlling a task finishing in an executor