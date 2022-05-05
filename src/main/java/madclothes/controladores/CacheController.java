package madclothes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

public class CacheController {
	@Autowired
    private CacheManager cacheManager;

    @RequestMapping(value="/cacheProducto", method= RequestMethod.GET)
    public Map<Object, Object> getCacheProductoContent() {
        ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
        ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("Producto");
        return cache.getNativeCache();
    }

    @RequestMapping(value="/cacheCarritoCompra", method= RequestMethod.GET)
    public Map<Object, Object> getCacheCarritoCompraContent() {
        ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
        ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("CarritoCompra");
        return cache.getNativeCache();
    }

    @RequestMapping(value="/cacheWebUser", method= RequestMethod.GET)
    public Map<Object, Object> getCacheWebUserContent() {
        ConcurrentMapCacheManager cacheMgr = (ConcurrentMapCacheManager) cacheManager;
        ConcurrentMapCache cache = (ConcurrentMapCache) cacheMgr.getCache("WebUser");
        return cache.getNativeCache();
    }
}




