import { HttpInterceptorFn } from '@angular/common/http';
import { getClientId } from './client-id.util';

export const clientIdInterceptor: HttpInterceptorFn = (req, next) => {
  const clientId = getClientId();

  return next(
    req.clone({
      setHeaders: {
        'X-Client-Id': clientId,
      },
    }),
  );
};
