import { Injectable } from '@angular/core';
import {Photo} from '../models/photo';
import {HttpClient} from '@angular/common/http';
import {User} from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {

  constructor(private http: HttpClient) { }

  getPhotos() {
    return this.http.get('http://localhost:8080/photo/allPhotos');
  }
}






