FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_usom01 = " \
        file://0001-weston1.9.0-Enabling-DRM-backend-with-multiple-displ.patch \
        file://0002-Weston1.9.0-Allow-visual_id-to-be-0.patch \
        file://0003-Weston1.9.0-Fix-virtual-keyboard-display-issue-for-Q.patch \
        file://0004-Weston1.9.0-Fix-touch-screen-crash-issue.patch \
"

DEPENDS_append_usom01 = " libgbm"

PACKAGECONFIG_usom01 = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'kms fbdev wayland egl', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'pam', 'launch', '', d)} \
                   ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd', '', d)} \
"

PACKAGECONFIG[kms] = "--enable-drm-compositor,--disable-drm-compositor,drm udev virtual/egl mtdev"
PACKAGECONFIG[wayland] = "--enable-wayland-compositor,--disable-wayland-compositor,virtual/egl"
