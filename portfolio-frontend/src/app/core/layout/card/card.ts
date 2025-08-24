import {ChangeDetectionStrategy, Component, Input} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';

/**
 * @title Card overview
 */
@Component({
  selector: 'app-card',
  templateUrl: 'card.html',
  styleUrl: 'card.scss',
  imports: [MatCardModule, MatButtonModule],
  changeDetection: ChangeDetectionStrategy.OnPush,
  standalone: true
})
export class Card {
  @Input() title: string = '';
  @Input() imageUrl: string = '';
  @Input() description: string = '';
  @Input() linkUrl: string = '#';
  @Input() linkText: string = 'LINK';

  isZoomed = false;

  toggleZoom() {
    this.isZoomed = !this.isZoomed;
  }
}


/**  Copyright 2025 Google LLC. All Rights Reserved.
    Use of this source code is governed by an MIT-style license that
    can be found in the LICENSE file at https://angular.io/license */