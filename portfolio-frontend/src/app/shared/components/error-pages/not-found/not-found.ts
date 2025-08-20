import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';
import { ButtonComponent } from "../../../../core/layout/button/button.component";

@Component({
  selector: 'app-not-found',
  imports: [RouterModule, ButtonComponent],
  templateUrl: './not-found.html',
  styleUrl: './not-found.scss'
})
export class NotFound {
  constructor(private router: Router) {}

  handlebuttonclick(): void {
    this.router.navigate(['/about'])
  }

  
}
