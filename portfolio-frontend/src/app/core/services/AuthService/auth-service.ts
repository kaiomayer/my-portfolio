import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {LoginPayload} from '../../../shared/models/login.model';
import {Observable, tap} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl: string = 'http://localhost:8080/api/v1/auth';
  private readonly JWT_TOKEN : string = 'jwt';

  constructor(private http: HttpClient) {
  }

  /**
   * Logs in the user and stores the JWT token in a cookie.
   * @param credentials The user's login credentials (e.g., { email: '...', password: '...' }).
   * @returns An observable with the server's response.
   */
  login(credentials: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/login`, credentials).pipe(
      tap(response => {
        // Assuming the token is in a 'token' property of the response
        if (response && response.token) {
          // Store the token for 7 days
          this.storeToken(response.token, 7);
        }
      })
    );
  }

  /**
   * Logs out the user by removing the token cookie.
   */
  logout(): void {
    this.removeToken();
    // Optionally, navigate the user to the login page or home page
  }

  /**
   * Checks if a JWT token cookie exists.
   * @returns True if the user is logged in, false otherwise.
   */
  isLoggedIn(): boolean {
    return !!this.getJwtToken();
  }

  /**
   * Retrieves the JWT token from cookies.
   * @returns The stored JWT token, or null if it doesn't exist.
   */
  getJwtToken(): string | null {
    return this.getCookie(this.JWT_TOKEN);
  }

  /**
   * Stores the JWT token in a browser cookie.
   * @param token The JWT token to store.
   * @param days The number of days until the cookie expires.
   */
  private storeToken(token: string, days: number): void {
    this.setCookie(this.JWT_TOKEN, token, days);
  }

  /**
   * Removes the JWT token cookie.
   */
  private removeToken(): void {
    this.deleteCookie(this.JWT_TOKEN);
  }

  // --- Cookie Helper Methods ---

  /**
   * Sets a cookie with a given name, value, and expiration in days.
   * @param name The name of the cookie.
   * @param value The value of the cookie.
   * @param days The number of days until expiration.
   */
  private setCookie(name: string, value: string, days: number): void {
    let expires = "";
    if (days) {
      const date = new Date();
      date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
      expires = "; expires=" + date.toUTCString();
    }
    // Added SameSite=Strict for better security
    document.cookie = name + "=" + (value || "") + expires + "; path=/; SameSite=Strict";
  }

  /**
   * Gets a cookie value by name.
   * @param name The name of the cookie to retrieve.
   * @returns The cookie's value or null if not found.
   */
  private getCookie(name: string): string | null {
    const nameEQ = name + "=";
    const ca = document.cookie.split(';');
    for (let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) === ' ') {
        c = c.substring(1, c.length);
      }
      if (c.indexOf(nameEQ) === 0) {
        return c.substring(nameEQ.length, c.length);
      }
    }
    return null;
  }

  /**
   * Deletes a cookie by name.
   * @param name The name of the cookie to delete.
   */
  private deleteCookie(name: string): void {
    // To delete a cookie, we set its expiration date to a past date.
    document.cookie = name + '=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
  }

}
