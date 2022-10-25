SUMMARY = "A minimal console-only base image for seeed reterminal"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require recipes-core/images/core-image-minimal.bb
inherit core-image

#
# Enable iptable firewall
#
CORE_IMAGE_EXTRA_INSTALL = "firewall"

#
# Set root password
# using openssl passwd p@ssw0rd
#
INHERIT += "extrausers"
EXTRA_USERS_PARAMS = "usermod -p yKMNZ4imKnbb6 root;"
INHERIT += "chageusers"
CHAGE_USERS_PARAMS = "chage -d0 root;"

#
# Extra image configuration defaults
#
IMAGE_FEATURES += "debug-tweaks"