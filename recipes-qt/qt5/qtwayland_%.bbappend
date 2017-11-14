FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://qtwayland-cast.patch"

OE_QMAKE_CXXFLAGS_append_imxgpu2d = " \
    -DLINUX \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '-DEGL_API_FB -DEGL_API_WL', '', d)} \
"
QT_CONFIG_FLAGS += "-no-xkbcommon-evdev"
