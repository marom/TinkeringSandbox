import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home.component';
import { PhotoListComponent } from './components/photo-list/photo-list.component';

import { PhotoService} from './services/photo.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PhotoListComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    PhotoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
