/*
 *  Copyright 2020 Yury Kharchenko
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package javax.microedition.lcdui.graphics;

import android.content.Context;
import android.view.SurfaceView;
import android.view.View;

import javax.microedition.lcdui.Canvas;

import androidx.annotation.NonNull;

public class CanvasView extends SurfaceView {

	private final Canvas owner;

	public CanvasView(Canvas owner, Context context) {
		super(context);
		this.owner = owner;
	}

	@Override
	protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
		super.onVisibilityChanged(changedView, visibility);
		// Fix keyboard issue on Blackberry
		if (visibility == VISIBLE) {
			requestFocus();
		}
	}

	@Override
	protected void onDraw(android.graphics.Canvas canvas) {
		owner.onDraw(canvas);
	}
}