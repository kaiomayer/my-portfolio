import { Injectable } from '@angular/core';
import {AuthService} from '../../services/AuthService/auth-service';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  /**
   * Intercepts outgoing HTTP requests and adds the JWT token to the Authorization header.
   * @param request The outgoing HTTP request.
   * @param next The next interceptor in the chain.
   * @returns An observable of the HTTP event stream.
   */
  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    // Get the auth token from the service.
    const authToken = this.authService.getJwtToken();

    // Clone the request and add the authorization header if the token exists.
    if (authToken) {
      const authReq = request.clone({
        headers: request.headers.set('Authorization', `Bearer ${authToken}`)
      });
      // Pass the cloned request instead of the original request to the next handle
      return next.handle(authReq);
    }

    // If no token, pass the original request
    return next.handle(request);
  }
}
