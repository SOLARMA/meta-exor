QT5_BASE = "\
	qtbase \
	qtmultimedia \
	qtimageformats \
"

QT5_GRAPHICS = "\
	qt3d \
	qtcanvas3d \
	qtquickcontrols \
	qtquick1 \
	qtquick1-plugins \
	qtquick1-qmlplugins \
	qtquickcontrols \
	qtquickcontrols-qmlplugins \
	qtquickcontrols2 \
	qtquickcontrols2-qmlplugins \
	qtgraphicaleffects \
	qtsmarthome \
	cinematicexperience \
	qt5nmapcarousedemo \
"

IMAGE_INSTALL += "\
	oprofile \
	iproute2 \
	canutils \
	vim \
	jmobile-portable \
	openvpn \
	openssh-sftp-server \
	gst-meta-base \
	packagegroup-cli-tools \
	packagegroup-cli-tools-debug \
	e2fsprogs \
	gdbserver \
	kernel-modules \
	${QT5_BASE} \
"

IMAGE_FEATURES_remove = "ssh-server-dropbear"
IMAGE_FEATURES += "ssh-server-openssh"

# Uncomment to include chromium web browser on the board. The build
# requires at least 8GB of free RAM memory otherwise the linking phase may fail
#CORE_IMAGE_EXTRA_INSTALL += "chromium"

inherit populate_sdk_qt5

TOOLCHAIN_OUTPUTNAME = "exor-evm-qt5-sdk"
