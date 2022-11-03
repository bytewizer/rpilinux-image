#!/bin/bash

# Abort script if any command returns error
set -e

IMAGE="rpilinux-image"
BUILD_DIR="build"

# Source build environment
source ./poky/oe-init-build-env $BUILD_DIR

# Add BSP layer
bitbake-layers add-layer ../meta-rpilinux
bitbake-layers add-layer ../poky/meta-raspberrypi
bitbake-layers add-layer ../poky/meta-openembedded/meta-oe
bitbake-layers add-layer ../poky/meta-openembedded/meta-python
bitbake-layers add-layer ../poky/meta-openembedded/meta-multimedia
bitbake-layers add-layer ../poky/meta-openembedded/meta-networking

# Build
bitbake --dry-run $IMAGE
#bitbake $IMAGE
