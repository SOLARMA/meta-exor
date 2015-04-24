IMAGE_FEATURES_remove = "ssh-server-dropbear"
IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_INSTALL += "jmobile-portable gdbserver openvpn openssh-sftp-server"

ROOTFS_POSTPROCESS_COMMAND += "tar xzf ${IMAGE_ROOTFS}/home/root/jmobile_portable_alterakit_cds3.tar.gz -C ${IMAGE_ROOTFS}/home/root; rm ${IMAGE_ROOTFS}/home/root/jmobile_portable_alterakit_cds3.tar.gz"

# Uncomment to install Qt library on the board
#IMAGE_INSTALL += "packagegroup-core-qt-demoapps packagegroup-qt-toolchain-target"

# Uncomment to include chromium web browser on the board
#CORE_IMAGE_EXTRA_INSTALL += "chromium"

