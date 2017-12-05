#
# Wayland based image
#

require recipes-graphics/images/core-image-weston.bb

# It's a Wayland only image
REQUIRED_DISTRO_FEATURES = "wayland"
CONFLICT_DISTRO_FEATURES = "x11"

COMPATIBLE_MACHINE = "(us01-kit|usom03)"

IMAGE_INSTALL += " \
	qtwayland \
        qtwayland-plugins \
	${QT5_GRAPHICS} \
"

# Sitara SGX libraries
IMAGE_INSTALL_append_usom01 = " kernel-module-ti-am335x-tsc ti-sgx-ddk-km"

# iMX6 Vivante libraries
IMAGE_INSTALL_append_usom03 = " \
		libopenvg-mx6 libgal-mx6 \
		libvdk-mx6 libvsc-mx6 \
		libopencl-mx6 libglslc-mx6 \
"

require core-image-exor.inc

export IMAGE_BASENAME = "core-image-exor-wayland"
