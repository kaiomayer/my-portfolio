import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Mail {
  public httpClient: HttpClient;

  constructor(private http: HttpClient) {
    this.httpClient = http;
  }

  public sendEmail(emailData : Mail): Observable<any> {
    return this.http.post<Mail>(this.httpClient + '/email', emailData);
  }
}
