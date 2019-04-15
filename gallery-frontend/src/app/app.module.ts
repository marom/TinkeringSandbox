import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HomeComponent} from './components/home.component';
import {PhotoListComponent} from './components/photo-list/photo-list.component';
import {SidePanelComponent} from './components/side-panel/side-panel.component';

import {PhotoService} from './services/photo.service';
import {RegisterService} from "./services/register.service";
import {NavBarComponent} from './components/nav-bar/nav-bar.component';
import {RegisterComponent} from './components/register/register.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {LoginComponent} from './components/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PhotoListComponent,
    SidePanelComponent,
    NavBarComponent,
    RegisterComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    PhotoService,
    RegisterService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
