SUMMARY = "A minimal console-only base image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit core-image

#
# Supported languages
#
IMAGE_LINGUAS = "en-us"

#
# defined hardware-specific features supported on the board
#
MACHINE_FEATURES += "bluetooth wifi keyboard"

#
# Software features shipped 
#
DISTRO_FEATURES:append = "bluetooth wifi keyboard"

#
# Extra image configuration defaults
#
EXTRA_IMAGE_FEATURES ?= "package-management"

#
# Enable systemd in configuration
#
INIT_MANAGER = "systemd"

#
# Additional installed packages
#
CORE_OS = "\
	openssh \ 
	openssh-sftp-server \
	openssl \
"

EXTRA_TOOLS = "\
	bash \
	nano \
	curl \
	wpa-supplicant \
	dotnet-scripts \
	i2c-tools \
"

IMAGE_INSTALL:append = " \
    ${CORE_OS} \
    ${EXTRA_TOOLS} \
"

#
# Enable u-boot kernel image
#
RPI_USE_U_BOOT = "1"

#
# Enable wic format for flashing to sdcard
#
IMAGE_FSTYPES = "wic"

#
# Increase the size (1GB) of root file system
#
IMAGE_ROOTFS_EXTRA_SPACE = "1024000"

#
# Enable UART console access
#
ENABLE_UART = "1"

#
# Enable the SPI bus
#
ENABLE_SPI_BUS = "1"

#
# Enable the I2C and auto-load I2C kernel modules
#
ENABLE_I2C = "1"
KERNEL_MODULE_AUTOLOAD:rpi += "i2c-dev i2c-bcm2708"