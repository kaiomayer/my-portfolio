import { Component } from '@angular/core';
import {GenericInput} from '../../shared/components/generic-input/generic-input';
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {LoginPayload} from '../../shared/models/login.model';

@Component({
  selector: 'app-login',
  imports: [
    GenericInput,
    ReactiveFormsModule
  ],
  templateUrl: './login.html',
  styleUrl: './login.scss'
})
export class Login {
  public loginForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.loginForm = this.formBuilder.group({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    })
  }

  private preparePayload() : LoginPayload {
    return this.loginForm.value as LoginPayload;
  }

  onSubmit() {

  }
}
