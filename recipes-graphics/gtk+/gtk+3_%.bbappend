PACKAGECONFIG[wayland] = "--enable-wayland-backend,--disable-wayland-backend,wayland libxkbcommon virtual/egl wayland-native"

DEPENDS += "${@bb.utils.contains('PACKAGECONFIG', 'wayland', 'wayland-protocols', '', d)}"

