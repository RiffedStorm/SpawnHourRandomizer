# Spawn Hour Randomizer

**A lightweight [NeoForge](https://github.com/neoforged/NeoForge) mod for Minecraft 1.21.1 that randomizes the time of day when a new world is first created.**

[![Minecraft](https://img.shields.io/badge/Minecraft-1.21.1-blue)](https://www.minecraft.net/)
[![NeoForge](https://img.shields.io/badge/NeoForge-21.1.252-orange)](https://github.com/neoforged/NeoForge)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## Why?

Every Minecraft world starts at the exact same time of day — bright morning. But what if each new save began at a random hour, including night? That's exactly what this mod does.

It picks a random tick value between 0 and 23999 (a full in-game cycle) on your very first world load and keeps it that way for the rest of that world's life — so every new game feels fresh with its own unique sunrise or moonrise.

## Features

- **Random spawn time** — each brand-new world starts at a random time between 0–23999 ticks
- **One-time only** — runs once per save, then remembers via persistent data (no re-randomizing on reloads)
- **Works without cheats** — no command permissions needed, so it's fully compatible with Hardcore mode

## Installation

1. Download the `.jar` from the [Releases](#) page.
2. Place it in your `mods/` folder (same folder as your Minecraft instance).
3. Launch Minecraft 1.21.1 with NeoForge 21.1.252 installed.

That's it — no configs, no extra setup. Just create a new world and enjoy the surprise!

## Development

Clone this repo and open it in IntelliJ IDEA (or your IDE of choice). Gradle handles everything:

```bash
./gradlew runClient   # launch a development instance
./gradlew build        # compile to /build/libs/
```

Requires **Java 21** and NeoForge's ModDevGradle plugin. See `build.gradle` for details.

## Note
This project was made with an AI hosted locally by [Qwen3.6-35B-A3B-Claude-4.7-Opus-Reasoning-Distilled — APEX-MTP Quality GGUF](https://huggingface.co/mudler/Qwen3.6-35B-A3B-Claude-4.7-Opus-Reasoning-Distilled-APEX-MTP-GGUF)

## License

This project is licensed under the [MIT License](LICENSE). You're free to use, modify, and distribute it — just include a copy of this license in any derived work.
