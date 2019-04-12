import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { PhotoListComponent } from './home/photo-list/photo-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PhotoListComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
