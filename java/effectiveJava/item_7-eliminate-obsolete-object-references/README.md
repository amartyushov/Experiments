* Whenever a class manages its own memory, the programmer should be alert for memory leaks
* Another common memory leaks are caches (WeakHashMap). Clean cache of unused entries.
* 3rd common source of memory leaks: listeners and callbacks. (Clients register callbacks, but not deregister)
    * to ensure callbacks are garbage collected is to store only weak references to them, e.g. by storing
    only as keys in Weak HashMap

use heap profiler to catch memory leaks
    
