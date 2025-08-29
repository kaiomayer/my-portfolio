import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Mail} from '../../../shared/models/mail.model';

@Injectable({
  providedIn: 'root'
})
export class MailService {
  private httpClient: HttpClient;
  private BASE_URL = 'https://my-portfolio-1-jr71.onrender.com/api/v1/emails';

  public constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  public sendMail(mailData : Mail) : Observable<Mail>{
    return this.httpClient.post<Mail>(this.BASE_URL, mailData);
  }
}
