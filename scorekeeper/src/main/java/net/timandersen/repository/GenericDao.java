package net.timandersen.repository;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;


//** Used example from https://www.hibernate.org/328.html
@SuppressWarnings({"unchecked"})
public class GenericDao<T> extends HibernateDaoSupport {

    private Class<T> persistentClass;

    public GenericDao() {
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    public void delete(T entity) {
        getHibernateTemplate().delete(entity);
        getHibernateTemplate().flush();
    }


    public void deleteAll(Collection<T> entities) {
        getHibernateTemplate().deleteAll(entities);
    }


    public List<T> findAll() {
        return getHibernateTemplate().loadAll(persistentClass);
    }


    public List<T> findByCriteria(DetachedCriteria criteria) {
        return getHibernateTemplate().findByCriteria(criteria);
    }


    public T findById(Long id) {
        return (T) getHibernateTemplate().load(persistentClass, id);
    }


    public T load(Serializable id) {
        return (T) getHibernateTemplate().load(persistentClass, id);
    }


    public void save(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
        getHibernateTemplate().flush();
    }


    public void saveOrUpdateAll(Collection<T> entities) {
        getHibernateTemplate().saveOrUpdateAll(entities);
        getHibernateTemplate().flush();
    }


    protected T firstOrNull(List<T> list) {
        return list.size() == 0 ? null : list.get(0);
    }

}
