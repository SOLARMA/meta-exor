#
# Wayland based image
#

require recipes-graphics/images/core-image-weston.bb

IMAGE_FEATURES += "ssh-server-openssh"

QT5 += "qtwayland"

require core-image-exor.inc

export IMAGE_BASENAME = "core-image-exor-wayland"
