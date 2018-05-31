* How to start selenoid
```bash
docker run -d                                   \
--name selenoid                                 \
-p 4444:4444                                    \
-v /var/run/docker.sock:/var/run/docker.sock    \
-v `pwd`/config:/etc/selenoid/:ro              \
aerokube/selenoid:latest-release
```

* Pull all necessary browser docker images
```bash
cat /path/to/browsers.json | jq -r '..|.image?|strings' | xargs -I{} docker pull {}
```  

* Enable vnc for browser container  
```capabilities.setCapability("enableVNC", true);```    
choose appropriate image  
```selenoid/vnc:firefox_60.0```

* Selenoid container with video recording
```bash
docker run -d                                   \
--name selenoid                                 \
-p 4444:4444                                    \
-v /var/run/docker.sock:/var/run/docker.sock    \
-v `pwd`/config/:/etc/selenoid/:ro              \
-v `pwd`/video/:/opt/selenoid/video/            \
-e OVERRIDE_VIDEO_OUTPUT_DIR=`pwd`/video/       \
aerokube/selenoid:latest-release
```

