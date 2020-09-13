
- ？加数字表示占位符，？1代表在方法参数里的第一个参数，区别于其他的index，这里从1开始

- =: 加上变量名，这里是与方法参数中有@Param的值匹配的，而不是与实际参数匹配的

- JPQL的语法中，表名的位置对应Entity的名称，字段对应Entity的属性,详细语法见相关文档

- 要使用原生SQL需要在@Query注解中设置nativeQuery=true，然后value变更为原生SQL即可

- 在使用@Modifying注解的时候，一定要加上事务注解@Transactional
