package madclothes.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


public class cachecontroller {


    @Autowired
    private CacheManager cacheManager;

    @RequestMapping(value="/cacheUsuarios", method= RequestMethod.GET)
    public Map<Object, Object> getCacheReservasContent() {
        ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
        ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("usuarios");
        return cache.getNativeCache();
    }

    @RequestMapping(value="/cacheProductos", method= RequestMethod.GET)
    public Map<Object, Object> getCacheSalasContent() {
        ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
        ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("productos");
        return cache.getNativeCache();
    }

}
