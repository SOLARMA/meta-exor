QT5_BASE = "\
	qtbase \
	qtmultimedia \
	qtmultimedia-examples \
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

TOOLS = "\
	bash \
	htop \
	lsof \
	nano \
	nmon \
	powertop \
	screen \
	socat \
	sysstat \
	evtest \
	devmem2 \
	i2c-tools \
	gdb \
	procps \
 	strace \
 "

GSTREAMER = "\
	gstreamer1.0-meta-base \
	gstreamer1.0-meta-video \
	gstreamer1.0-plugins-good \
	gstreamer1.0-plugins-bad \
"

IMAGE_INSTALL += "\
	oprofile \
	iproute2 \
	canutils \
	vim \
	jmobile-portable \
	openvpn \
	openssh-sftp-server \
	e2fsprogs \
	gdbserver \
	kernel-modules \
	${GSTREAMER} \
	${QT5_BASE} \
	${TOOLS} \
"

IMAGE_FEATURES_remove = "ssh-server-dropbear"
IMAGE_FEATURES += "ssh-server-openssh"

# Uncomment to include chromium web browser on the board. The build
# requires at least 8GB of free RAM memory otherwise the linking phase may fail
#CORE_IMAGE_EXTRA_INSTALL += "chromium"

inherit populate_sdk_qt5

# Required by qtcreator debugger
TOOLCHAIN_HOST_TASK += "nativesdk-python3-json"

TOOLCHAIN_OUTPUTNAME = "${SDKMACHINE}-exor-${MACHINE}-qt5-x11-sdk-${DISTRO_VERSION}"
