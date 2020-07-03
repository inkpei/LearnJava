# docker 备忘录

[docker format 使用](https://www.jianshu.com/p/65377285662e)

## ubuntu 国内源

### 模板

```bash
cp /etc/apt/sources.list /etc/apt/sources.list.bak
echo "" > /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal main restricted" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-updates main restricted" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal universe" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-updates universe" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal multiverse" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-updates multiverse" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-backports main restricted universe multiverse" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-security main restricted" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-security universe" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-security multiverse" >> /etc/apt/sources.list
apt-get clean
apt-get update
```

将 `http://mirrors.tuna.tsinghua.edu.cn` 替换为自己喜欢的源即可

```bash
# 阿里云
http://mirrors.aliyun.com
#163
http://mirrors.163.com
```

## docker 容器替换国内源

```bash
cp /etc/apt/sources.list /etc/apt/sources.list.bak
echo "" >  /etc/apt/sources.list
echo "deb http://mirrors.163.com/debian/ jessie main non-free contrib" >> /etc/apt/sources.list
echo "deb http://mirrors.163.com/debian/ jessie-proposed-updates main non-free contrib" >>/etc/apt/sources.list
echo "deb-src http://mirrors.163.com/debian/ jessie main non-free contrib" >>/etc/apt/sources.list
echo "deb-src http://mirrors.163.com/debian/ jessie-proposed-updates main non-free contrib" >>/etc/apt/sources.list
apt-get update
```


## docker 相关操作
所有容器ID

```
docker ps -aq
```
查看所有运行或者不运行容器

```
docker ps -a
```
停止所有的container（容器），这样才能够删除其中的images：
```
docker stop $(docker ps -a -q) 或者 docker stop $(docker ps -aq) 
```
如果想要删除所有container（容器）的话再加一个指令：
```
docker rm $(docker ps -a -q) 或者 docker rm $(docker ps -aq) 
```
查看当前有些什么images
```
docker images
```

删除images（镜像），通过image的id来指定删除谁
```
docker rmi <image id>
 ```
想要删除untagged images，也就是那些id为的image的话可以用
```
docker rmi $(docker images | grep "^<none>" | awk "{print $3}")
 ```
要删除全部image（镜像）的话
```
docker rmi $(docker images -q)
 ```
强制删除全部image的话
```
docker rmi -f $(docker images -q)
```

停止、启动、杀死、重启一个容器

```
docker stop Name或者ID  
docker start Name或者ID  
docker kill Name或者ID  
docker restart name或者ID
 ```


## redis 相关操作

https://www.jianshu.com/p/f7f7ab47cc3a

启动

```bash
 docker run -itd --name redis -p 6379:6379 -v $PWD/redis.conf:/etc/redis/redis.conf --privileged=true redis redis-server /etc/redis/redis.conf
```

连接

```bash
docker exec -it 3017 redis-cli
```

