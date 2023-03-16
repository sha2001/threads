```mermaid
graph TB
    
    New -- admitted --> Runnable
    Runnable -- scheduler dispatch --> Running
    Running -- exit --> Terminated
    Running -- wait --> Non-Runnable
    Non-Runnable -- notify --> Runnable
    Running -- interrupt --> Runnable

```
