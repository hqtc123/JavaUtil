示例：     http://www.iteye.com/topic/103804

hibernate中threadLocal的用法

private static final ThreadLocal<Session> threadSession = new ThreadLocal();

public static Session getSession() throws InfrastructureException {
    Session s = (Session) threadSession.get();
    try {
        if (s == null) {
            s = getSessionFactory().openSession();
            threadSession.set(s);
        }
    } catch (HibernateException ex) {
        throw new InfrastructureException(ex);
    }
    return s;
}

可以看到在getSession()方法中，首先判断当前线程中有没有放进去session，如果还没有，
那么通过sessionFactory().openSession()来创建一个session，再将session set到线程中，
实际是放到当前线程的ThreadLocalMap这个map中，这时，对于这个session的唯一引用就是当前
线程中的那个ThreadLocalMap（下面会讲到），而threadSession作为这个值的key，
要取得这个session可以通过threadSession.get()来得到，里面执行的操作实际是先取得当前线程中的ThreadLocalMap，
然后将threadSession作为key将对应的值取出。这个session相当于线程的私有变量，而不是public的。
显然，其他线程中是取不到这个session的，他们也只能取到自己的ThreadLocalMap中的东西。
要是session是多个线程共享使用的，那还不乱套了。

