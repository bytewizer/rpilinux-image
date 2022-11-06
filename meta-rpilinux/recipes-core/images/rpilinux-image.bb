SUMMARY = "A minimal console-only base image for the Raspberry Pi"
HOMEPAGE = "https://www.raspberrypi.com/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-core/images/core-image-minimal.bb

# Extra image configuration defaults
EXTRA_IMAGE_FEATURES ?= "ssh-server-openssh"

# Software features shipped 
DISTRO_FEATURES:append = " wifi bluetooth"

# Additional installed packages
CORE_OS = "\
	kernel-modules \
	linux-firmware-bcm43430 \
	bluez5 \
    openssh \ 
	openssh-sftp-server \
	openssl \
	sudo \
	iptables \
"

HARDWARE_TOOLS = "\
	usbutils \
	can-utils \
	ethtool \
	libgpiod \
	libgpiod-dev \
	libgpiod-tools \
	i2c-tools \
"

WIFI_TOOLS = " \
	iw \
	wpa-supplicant \
"

EXTRA_TOOLS = "\
	bash \
	nano \
	curl \
	dotnet \
	dotnet-scripts \
	vsdbg-dbg \
"

IMAGE_INSTALL:append = " \
    ${CORE_OS} \
    ${HARDWARE_TOOLS} \
	${WIFI_TOOLS} \
	${EXTRA_TOOLS} \
"

# Enable wic format for flashing to sdcard
IMAGE_FSTYPES = "wic"

#
# Set the size of root file system to 32GB
#
# IMAGE_ROOTFS_SIZE = "319488" 
# IMAGE_OVERHEAD_FACTOR = "1.1"
IMAGE_ROOTFS_EXTRA_SPACE = "512"
# IMAGE_ROOTFS_MAXSIZE = "372736"

#IMAGE_ROOTFS_SIZE = "5120" 

# Remove debugging tweaks. This allows the root user to be passwordless.
# IMAGE_FEATURES:remove = " \
#     debug-tweaks \
# "

# Set root password
# inherit extrausers
# ROOT_PASSWORD ??= "root"
# ROOT_PASSWORD_ENCRYPTED ??= "$(openssl passwd -5 ${ROOT_PASSWORD})"
# EXTRA_USERS_PARAMS += "usermod -p '${ROOT_PASSWORD_ENCRYPTED}' root;"