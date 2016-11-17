# Running in dev mode

* `boot dev`

## Prerequisites

The build uses [J2V8](https://github.com/eclipsesource/J2V8), the Java bindings to V8. You should either build it or put the binary library on your `java.library.path`. On OS X:

```shell
wget https://github.com/eclipsesource/J2V8/releases/download/v4.5.0/libj2v8_macosx_x86_64.dylib
mv libj2v8_macosx_x86_64.dylib /Users/skuro/Library/Java/Extensions/
```

# Deploying changes

* `make release` which will generate production version of a website, copy it to the `docs` folder, commit and push the changes.
