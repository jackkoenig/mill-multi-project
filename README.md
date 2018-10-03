# mill-multi-project

This is an example project for illustrating a specific case of multi-project build with mill.

See Pull Requests for attempts to make this work! https://github.com/jackkoenig/mill-multi-project/pulls

[One of them even works](https://github.com/jackkoenig/mill-multi-project/pull/2) although it has some issues.

## Problem Statement

In this example, we have 3 projects: `top`, `bar`, and `foo`.

1. `foo` has no dependencies and can be compiled and run on it's own
2. `bar` has an ivy dependency on `foo`
3. `top` has a module dependency on `foo` and `bar`

To build this, you need to first publish `foo` and then you can run `top`:

```
> cd foo
> mill foo.publishLocal
> cd ..
> mill top.run
```

What I would like to be able to do, is to override `bar`'s ivy dependencies, removing the one on foo, 
and replace it with a module dependency on `foo`. In that case, you would no longer need to publish `foo`,
instead you could just run `top` as is based on the build configuration.
