FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_usom01 = " \
	file://GraphicsSurfaceGL_NoX.cpp.patch \
	file://GraphicsSurfaceToken.h.patch \
	file://0001-Target.pri-update-to-use-GL_NoX-version-of-GraphicsS.patch \
	file://WebCore.pri.patch \
"
