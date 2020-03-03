
#! /usr/bin/env bash

sudo apt install git
sudo apt-get install python-dev python-tk
sudo apt-get install build-essential

if ! type -p pip > /dev/null ; then
  cd "$(mktemp -d)"
  wget https://bootstrap.pypa.io/get-pip.py
  sudo python get-pip.py
fi

sudo pip uninstall Pillow
sudo pip install "Pillow==1.7.8"

cd "$(mktemp -d)"
git clone https://github.com/scottopell/aggdraw-64bits
cd aggdraw-64bits
sudo python setup.py install

cd "$(mktemp -d)"
git clone https://github.com/3b1b/manim
cd manim
tail -n +2 ./requirements.txt > newrequirements.txt
sudo pip install -r newrequirements.txt