# mill-multi-project

This is an example project for illustrating a complex multi-module build with mill.

## Problem Statement

In this example, we have 4 projects: `top`, `bar`, `fizz`, and `foo`.

1. `foo` has no dependencies and can be compiled and run on its own
2. `fizz` is a "sub-module" of `bar` that has a dependency on `foo`
3. `bar` has a module dependency on `fizz`
4. `top` has a module dependency on `bar`

The purpose of this example is to illustrate that the dependency of `fizz` on `foo` can be *either*
an ivy dependency or a module dependency. By default in the `bar` directory, it uses an ivy
dependency. `top` creates a parallel `bar2` module that instead uses a module dependency on `foo`.

To run `top`, you do not need to publish `foo`, you can just run:

```
> mill top.run
```

To build `bar` in isolation, you need to first publish `foo` and then you can run `bar`:

```
> cd foo
> mill foo.publishLocal
> cd ../bar
> mill bar.run
```

