PACKAGECONFIG_usom01 = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland egl', '', d)} \
                 ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)}"
