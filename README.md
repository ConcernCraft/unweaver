## Unweaver
[![](https://jitpack.io/v/ConcernCraft/unweaver.svg)](https://jitpack.io/#ConcernCraft/unweaver)

NOTE: Unweaver is still in *early* development! It is largely incomplete and compatibility with other mods is **not yet** tested!
Use with caution!

Unweaver is an API that exposes interfaces and registries to extend functions that vanilla Minecraft outright hardcoded in the game.
This included enums, hardcoded condition checks, fixed strings, etc.

Features currently supported can be found [here](https://github.com/ConcernCraft/unweaver/wiki/Currently-Implemented-Features).
Want a new feature? Open a new issue on the issue tracker. :)

### How to use
Simply include Unweaver to your project via Jitpack:
```
repositories {
    ...
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.ConcernCraft:unweaver:<UNWEAVER_VERSION>'
}
```
Then replace `<UNWEAVER_VERSION>` with the version number of the latest release.

### I haz problemes
Please create a new issue in the issue tracker whenever an Unweaver-related issue appears.
If there is a massive bug that needs urgent attention please pester me in Fabricord, or DM me directly. Tag's `@leocth#3409`.
