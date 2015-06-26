IMAGE_FEATURES_remove = "ssh-server-dropbear"
IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL_append += "jmobile-portable gdbserver openvpn openssh-sftp-server gst-meta-base \
	gst-meta-video gst-meta-audio gst-plugins-good-meta qt4-plugin-phonon-backend-gstreamer"

JMobilePkg="${IMAGE_ROOTFS}/home/root/jmobile_alterakit.tar.gz"
ROOTFS_POSTPROCESS_COMMAND += "[ -f ${JMobilePkg} ] && tar xzf ${JMobilePkg} -C ${IMAGE_ROOTFS}/home/root; rm ${JMobilePkg}"

QT_PHONON = "-phonon -phonon-backend"

# Uncomment to install Qt library on the board
#IMAGE_INSTALL_append += "packagegroup-core-qt-demoapps packagegroup-qt-toolchain-target qt4-plugin-phonon-backend-gstreamer"

# Uncomment to include chromium web browser on the board
#CORE_IMAGE_EXTRA_INSTALL += "chromium"


