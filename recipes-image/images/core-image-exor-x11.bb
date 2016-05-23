#
# Sato/X11 based image
#

require recipes-sato/images/core-image-sato.bb

IMAGE_FEATURES_remove = "ssh-server-dropbear"
IMAGE_FEATURES += "ssh-server-openssh"

require core-image-exor.inc

export IMAGE_BASENAME = "core-image-exor-x11"
