# tree-domain [![Build Status](https://travis-ci.org/all-trees/tree-domain.svg?branch=master)](https://travis-ci.org/all-trees/tree-domain)

Code to model the binary tree domain


Usage
-----

```java
Builder builder = new Builder(new Checker("(", ")"));
Tree tree = builder.build("()(())");
```