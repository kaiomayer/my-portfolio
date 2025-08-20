import { Component } from '@angular/core';
import {GenericInput} from '../../shared/components/generic-input/generic-input';
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {LoginPayload} from '../../shared/models/login.model';
import {AuthService} from '../../core/services/AuthService/auth-service';
import {Router} from '@angular/router';
import {Hero} from '../../core/layout/hero/hero';
import {MatButton} from '@angular/material/button';

@Component({
  selector: 'app-login',
  imports: [
    GenericInput,
    ReactiveFormsModule,
    Hero,
    MatButton
  ],
  templateUrl: './login.html',
  styleUrl: './login.scss'
})
export class Login {
  public loginForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private authService : AuthService, private router : Router) {
    this.loginForm = this.formBuilder.group({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    })
  }

  private preparePayload() : LoginPayload {
    return this.loginForm.value as LoginPayload;
  }

  public getControl(control : string) {
    return this.loginForm.get(control) as FormControl;
  }

  onSubmit() {
    this.authService.login(this.preparePayload()).subscribe(
      {
        next: () => {
          console.table(this.preparePayload());
        },
        error: err => {
          console.error(`There was an error trying to log the user in: ${err.message}`);
          this.loginForm.reset();
        },
        complete: () => {
          this.router.navigate(['edit']).then(navigationSuccessful => {
            if (navigationSuccessful) {
              console.log('Navigation to edit page was successful!');
            } else {
              console.log('Navigation was cancelled by a guard.');
            }
          }).catch(error => {
              console.error('Navigation failed:', error);
            });
        }
      }
    );
  }
}
