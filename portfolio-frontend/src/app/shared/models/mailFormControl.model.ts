import {FormControl} from '@angular/forms';

export interface MailFormControl {
  control: FormControl;
  type: string;
  placeholder: string;
  label: string;
  required: boolean;
}
