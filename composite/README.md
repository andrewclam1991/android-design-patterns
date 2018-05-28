# Iterator and Composite Pattern
Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients
treat individual objects and compositions of objects uniformly. 

This module contains example of a composite iterable menu, where "Menu" and "MenuItem" are both
of type "MenuComponent". "Menu" is conceptually composed of "MenuItems", and can also contain sub
"Menu"s. "Menu" is a node, where "MenuItem" is a leaf.

Pros: 
- supports robust iteration without exposing underlying implementations to client

Cons:
- Java implementation would require "MenuComponent" to have default implementation of all
interface methods. Such implementation forces each default to just throw unsupported exception when