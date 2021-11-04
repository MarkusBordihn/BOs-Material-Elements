# Bo's Material Elements

![Bo's Material Elements][logo]{height=300px}

Bo's Material Elements is a Minecraft Forge Mod which adds additional materials and elements (like copper nuggets, steel, coke) for other related mods.

This mod is mostly useful for other mods which requires specific materials or elements and don't want to implement them self.

## Features ⭐

### Block Overview 👁️‍🗨️

### ➖ Rods

- Copper Rod (full, half-size, cross, star)
- Gold Rod (full, half-size, cross, star)
- Iron Rod (full, half-size, cross, star)
- Steel Rod (full, half-size, cross, star)
- Netherite Rod (full, half-size, cross, star)

#### 📦 Blocks

- Steel Block

#### ✨ Ore

- Steel Ore

### Item Overview 👁️‍🗨️

#### 🪨 Nuggets

- Copper Nugget
- Steel Nugget
- Netherite Nugget

#### 🪙 Ingot

- Steel Ingot

#### 🔭 Other Material

- Coke

### Recipe Overview 👁️‍🗨️

This mods adds a lot of additional crafting recipes to allow the crafting of the added elements or to simplify crafting of existing items like wood cutting.

## Mod Integration 🚀

If you want to use this mods material and elements for your own mod just add it as dependency and all elements are automatically available for your mod.

### 🗄️ Mod Dependency

Add the following lines to your **main/resources/META-INF/mods.toml** file:

```yaml
  [[dependencies.REPLACE_WITH_YOUR_MOD_ID]]
    modId="material_elements"
    mandatory=true
    # This version range declares a minimum of the current version up to but not including the next major version
    versionRange="[0.2.0,)"
    ordering="NONE"
    side="BOTH"
```

### 👾 Development Dependency

For an easier development workflow, you should at the following lines to your **build.gradle** file which will automatically download Bo's Material Elements as dependency for your local development environment.

```java
// Curse Maven Plugin
repositories {
    maven {
        url "https://www.cursemaven.com"
        content {
            includeGroup "curse.maven"
        }
    }
}

dependencies {

    ...

    // Required: Bo's Material Elements (dev dependency)
    implementation fg.deobf("curse.maven:material_elements-541620:3514413")
}
```

⚠️ Please keep in mind that you need to update the file version from time to time. I will try to keep the latest version in this documentation part.

[logo]: logo.png
